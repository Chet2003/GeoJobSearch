from selenium import webdriver
from bs4 import BeautifulSoup
from listing import Listing
import pytest
from indeedFunctions import addToLists
from populateDB import add_listings_to_DB, generate_connection
import time
import requests

def wait_for_selenium_server(url="http://seleniumstandalone:4444/wd/hub/status", timeout=30):
    """Wait for the Selenium server to become available."""
    start_time = time.time()
    while True:
        try:
            response = requests.get(url)
            if response.status_code == 200 and "value" in response.json():
                server_status = response.json()["value"]
                if server_status.get("ready", False):
                    print("Selenium server is ready.")
                    return True
            else:
                print("Selenium server not ready, waiting...")
        except requests.exceptions.RequestException as e:
            print("Selenium server connection failed: ", e)
        
        if time.time() - start_time > timeout:
            print("Timeout waiting for Selenium server.")
            return False
        time.sleep(2)  # Wait for 2 seconds before retrying

#Variables
place = "Guelph"
province = "ON"
q = "software+developer"
url = "https://ca.indeed.com/jobs?q=" + q + "&l=" + place + "%2C" + province
jobList = list()
companyList = list()
locationList = list()
listings = list()
tracker = 15
tracker2 = 10

#Enable and Use Pytest
enableTests = True
if enableTests == True:
    framework = pytest.main(["pytests/"])


# Wait for the Selenium server to be ready
if not wait_for_selenium_server():
    print("Failed to connect to Selenium server. Exiting.")
    exit(1)



options = webdriver.ChromeOptions()
options.add_argument('log-level=3')
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-shm-usage")

server = "http://seleniumstandalone:4444/wd/hub"

# driver = webdriver.Chrome()
driver = webdriver.Remote(command_executor=server, options=options) # directing the webdriver to selenium
# driver.implicitly_wait(10) # wait for page load
driver.get(url)
content = driver.page_source
soup = BeautifulSoup(content, "html.parser")

jobPostings = soup.find_all("td", class_="resultContent css-1qwrrf0 eu4oa1w0")
numEntries = soup.find("div", class_="jobsearch-JobCountAndSortPane-jobCount css-13jafh6 eu4oa1w0")

a = numEntries.text.replace("jobs", " ")
b = a.replace(",", "")
b.strip()
c = 20 # int(b)

addToLists(jobPostings,jobList,companyList,locationList)






while tracker <= c:
    # url = "https://ca.indeed.com/jobs?q=" + q + "&l="+ place + "%2C" + province + "&start=" + str(tracker2)
    url = "https://ca.indeed.com/jobs?q=" + q + "&l="+ place + "%2C" + "&start=" + str(tracker2)
    
    driver.get(url)

    content = driver.page_source
    soup = BeautifulSoup(content, "html.parser")
    
    jobPostings = soup.find_all("td", class_="resultContent css-1qwrrf0 eu4oa1w0")
    checker = soup.find("title", string="Just a moment...")

    if(checker != None):
        break
    
    addToLists(jobPostings,jobList,companyList,locationList)

    tracker += 15
    tracker2 += 10

driver.quit()

    

for item in range(len(jobList)):
    a = Listing(jobList[item], companyList[item], locationList[item])
    listings.append(a)
    print(a)

connection = generate_connection()

add_listings_to_DB(listings, connection)

    
    
    

