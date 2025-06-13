import pytest
import sys
sys.path.append('../')
from listing import Listing


@pytest.fixture
def createListing():
    return Listing("Title","Company","Location")

@pytest.mark.Listing
def test_getTitle(createListing):
    assert createListing.getTitle() == "Title"

@pytest.mark.Listing
def test_getCompany(createListing):
    assert createListing.getCompany() == "Company"
    
@pytest.mark.Listing
def test_getLocation(createListing):
    assert createListing.getLocation() == "Location"

