import os
import mysql.connector
from mysql.connector import Error
 
db_host  = os.getenv('DB_HOST', 'mysql')
db_database = os.getenv('DB_DATABASE', 'jobs_db')
db_user = os.getenv('DB_USER', 'root')
db_password = os.getenv('DB_PASSWORD', 'pwd')
   
db_config = {
    'host': db_host,
    'port': 3306,
    'user': db_user,
    'password': db_password,
    'database': db_database
}
 
def insert_job(cursor, job_title, company, location):
    """Insert a job into the Jobs table."""
    query = """INSERT INTO job (job_title, company, location) VALUES (%s, %s, %s)"""
    cursor.execute(query, (job_title, company, location))
    print("A job record inserted successfully.")

def generate_connection():
    return mysql.connector.connect(**db_config)
 
def add_listings_to_DB(listings, connection):
    try:
        # Connect to the database
        cursor = connection.cursor()

        # Process the text files and delete them after processing
        for listing in listings:
            insert_job(cursor, listing.title, listing.company, listing.location)

        connection.commit()
       
    except Error as e:
        print(f"Error: {e}")
    finally:
        if 'connection' in locals() or 'connection' in globals():
            if connection.is_connected():
                cursor.close()
                connection.close()
                print("MySQL connection is closed")
 