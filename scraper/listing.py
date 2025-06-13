class Listing:
    def __init__(self, title, company, location):
        self.title = title
        self.company = company
        self.location = location
        
    def getTitle(self):
        return self.title
    
    def getCompany(self):
        return self.company
    
    def getLocation(self):
        return self.location
    
    def __str__(self):
        return f"Job title: {self.title}\nCompany: {self.company}\nLocation: {self.location}\n\n"