import pytest
from selenium import webdriver
from bs4 import BeautifulSoup
import sys
sys.path.append('../')
from scraper.indeedFunctions import addToLists

driver = webdriver.Chrome()
listToTest = [("software+Engineer","Guelph","ON"),
    ("doctor","Edmonton","AB")]


def get_jobPostings(url):
    driver.get(url)
    content = driver.page_source
    soup = BeautifulSoup(content, "html.parser")
    return soup.find_all("td", class_="resultContent css-1qwrrf0 eu4oa1w0")


@pytest.mark.parametrize("parameter, place, province",listToTest)
def test_jobPostings(parameter,place,province):
    url = "https://ca.indeed.com/jobs?q=" + parameter + "&l=" + place + "%2C+" + province
    jobPostings = get_jobPostings(url)
    assert jobPostings != []
   
    
@pytest.mark.parametrize("parameter, place, province",listToTest)
def test_addToList(parameter,place,province):
    jobList = list()
    companyList = list()
    locationList = list()
    url = "https://ca.indeed.com/jobs?q=" + parameter + "&l=" + place + "%2C+" + province
    jobPostings = get_jobPostings(url)
    addToLists(jobPostings,jobList,companyList,locationList)
    assert len(jobList) == len(companyList) == len(locationList)
    











