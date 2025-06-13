from listing import Listing

def addToLists(jobPostings,jobList,companyList,locationList):
    for item in jobPostings:
        title = item.find("a", class_="jcs-JobTitle css-jspxzf eu4oa1w0")
        company =  item.find("span", class_="css-92r8pb eu4oa1w0").text
        location = item.find("div", class_="css-1p0sjhy eu4oa1w0").text

        if(title.find("span").text == ""):
            jobList.append("N/A")
        else:
            jobList.append(title.find("span").text)

        if(company == ""):
            companyList.append("N/A")
        else:
            companyList.append(company)

        if(location == ""):
            locationList.append("N/A")
        else:
            locationList.append(location)