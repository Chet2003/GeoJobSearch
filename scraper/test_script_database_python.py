import pytest
from unittest.mock import MagicMock, patch 
from mysql.connector import Error
from listing import Listing
from populateDB import insert_job, add_listings_to_DB, db_config
from unittest.mock import call

@pytest.fixture
def mock_connection():
    connection = MagicMock()
    cursor = connection.cursor.return_value
    return connection, cursor

def test_insert_job(mock_connection):
    connection, cursor = mock_connection
    job_title = "Test position"
    company = "Test company "
    location = "Test location"
    insert_job(cursor, job_title, company, location)
    cursor.execute.assert_called_once_with("""INSERT INTO job (job_title, company, location) VALUES (%s, %s, %s)""", (job_title, company, location, ))

def test_add_listings_to_DB(mock_connection): 
    connection, cursor = mock_connection

    test_listings = []
    test_listings.append(Listing('Test 1 Title','Test 1 Company','Test 1 Location'))
    test_listings.append(Listing('Test 2 Title','Test 2 Company','Test 2 Location'))

    add_listings_to_DB(test_listings, connection)

    cursor.execute.assert_any_call("""INSERT INTO job (job_title, company, location) VALUES (%s, %s, %s)""", (test_listings[0].title, test_listings[0].company, test_listings[0].location,))
    cursor.execute.assert_any_call("""INSERT INTO job (job_title, company, location) VALUES (%s, %s, %s)""", (test_listings[1].title, test_listings[1].company, test_listings[1].location,))
    connection.commit.assert_called_once()

def test_add_listings_to_DB_error(mock_connection): 
    connection, cursor = mock_connection

    """ Tests if an execption is thrown for listings being a string"""
    with pytest.raises(AttributeError) as excinfo:
        add_listings_to_DB("Test", connection)

    assert str(excinfo.value) == "'str' object has no attribute 'company'"

    """ Tests if an execption is thrown for listings being an integer"""
    with pytest.raises(TypeError) as excinfo:
        add_listings_to_DB(1111, connection)

    assert str(excinfo.value) == "'int' object is not iterable"

    """ Tests if an execption is thrown for listings being a list of integers"""
    test_list =[1,2,3,4]

    with pytest.raises(AttributeError) as excinfo:
        add_listings_to_DB(test_list, connection)

    assert str(excinfo.value) == "'int' object has no attribute 'title'"

    """ Tests if an execption is thrown for listings being a dictionary"""
    test_dict = {
        'key1': 1, 
        'key2': 2
    }

    with pytest.raises(AttributeError) as excinfo:
        add_listings_to_DB(test_dict, connection)

    assert str(excinfo.value) == "'str' object has no attribute 'company'"

