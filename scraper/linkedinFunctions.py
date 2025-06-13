from listing import Listing

def addToListings(cards, listings:list):
    for card in cards:
        jobTitle = card.find('h3', class_="base-search-card__title").getText().strip()
        company = card.find('h4', class_="base-search-card__subtitle").getText().strip()
        jobLocation = card.find('span', class_="job-search-card__location").getText().strip()
        
        if jobTitle == "":
            jobTitle = "N/A"
        if company == "":
            company = "N/A"
        if jobLocation == "":
            jobLocation = "N/A"
    
        jobComplete = Listing(jobTitle,company,jobLocation)
        listings.append(jobComplete)