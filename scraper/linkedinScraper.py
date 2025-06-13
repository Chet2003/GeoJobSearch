from selenium import webdriver
from bs4 import BeautifulSoup
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from linkedinFunctions import addToListings
import time

SCROLL_PAUSE_TIME = 1

chrome_options = Options()
chrome_options.add_experimental_option("detach", True)
chrome_options.add_argument("--start-maximized")
url = "https://www.linkedin.com/jobs/search?trk=guest_homepage-basic_guest_nav_menu_jobs&position=1&pageNum=0"

place = "Guelph"
province = "Ontario"
country = "Canada"
q = "software developer"
listings = list()

#Variables
driver = webdriver.Chrome(options=chrome_options)
driver.get(url)


keywords = driver.find_element(By.NAME,"keywords")
location = driver.find_element(By.NAME, "location")
location.clear()
submit = driver.find_element(By.CLASS_NAME, "base-search-bar__submit-btn")

keywords.send_keys(q)
location.send_keys(f"{place}, {province}, {country}")
location.send_keys(Keys.RETURN)

# Get scroll height
last_height = driver.execute_script("return document.body.scrollHeight")

while True:
    # Scroll down to bottom
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    time.sleep(SCROLL_PAUSE_TIME)    
    driver.execute_script('window.scrollBy(0, -40);')
    time.sleep(SCROLL_PAUSE_TIME)   
    driver.execute_script('window.scrollBy(0, 40);')
    time.sleep(SCROLL_PAUSE_TIME) 
    
    # Calculate new scroll height and compare with last scroll height
    new_height = driver.execute_script("return document.body.scrollHeight")
    if new_height == last_height:
        break
    last_height = new_height

content = driver.page_source
soup = BeautifulSoup(content, "html.parser")
cards = soup.find_all('div', class_="base-search-card__info")
addToListings(cards,listings)
print(len(listings))
driver.close()

for listing in listings:
    print(listing)
    
print(f"Number of listings: {len(listings)}")