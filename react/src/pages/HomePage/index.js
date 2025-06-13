import React, { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import { Row, Col, Table } from 'react-bootstrap';
import JobTable from './components/JobTable';
import GlobalNavBar from '../../components/GlobalNavBar';
import MapPage from '../../pages/MapPage';
import SearchBar from './components/SearchBar';


// TODO Make this data come from the call to the Python webscraper
const jobData = [
    { position: 'Engineer', salary: '40,000', description: 'Lorem Ipsum...' , location: 'Guelph'},
    { position: 'Developer', salary: '60,000', description: 'Lorem Ipsum...', location: 'Waterloo' },
    { position: 'Cook', salary: '120,000', description: 'Lorem Ipsum...', location: 'London' },
  ];


const HomePage = () => {
    const [searchValue, setSearchValue] = useState('');
    const [filteredJobs, setFilteredJobs] = useState(jobData);
    const [notes, setNotes] = useState([]);
    const [count, setCount] = useState(0);
    const [newNote, setNewNote] = useState('');
    const [showEdit, setShowEdit] = useState(false);
    const [noteToEdit, setNoteToEdit] = useState(null);
    const [loading, setLoading] = useState(false);
    const [loadingCount, setLoadingCount] = useState(false);
    const [error, setError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);

    const status = (res) => {
        if (!res.ok) {
            throw new Error('Something Went Wrong');
        }
        return res;
    }

    // Handle change event of the search input
    const handleInputChange = (event) => {
        setSearchValue(event.target.value);
    };

    // Optional: Handle form submit event
    const handleSubmit = (event) => {
        event.preventDefault(); // Prevent the form from refreshing the page, to be taken out later when we actually do want the page to refresh after input
        filterJobsLocation(searchValue);
        console.log("Search Value: ", searchValue); // Do something with the searchValue, ex.API call
    };

    //Function to filter job
    const filterJobsLocation = (searchValue) => {
        const filtered = jobData.filter(job => job.position.toLowerCase().includes(searchValue.toLowerCase()) || 
        job.salary.toLowerCase().includes(searchValue.toLowerCase()) ||
        job.location.toLowerCase().includes(searchValue.toLowerCase()));
        setFilteredJobs(filtered);
    }

    return (
        <div className="home-page">
            {/* <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={searchValue}
                    onChange={handleInputChange}
                    placeholder="Search..."
                />
                <button type="submit">Search</button>
            </form> */}
            <GlobalNavBar pageName='Home' />
            <Container>
                <Row>
                    <Col>
                        <MapPage />
                    </Col>
                    <Col >
                        {/* <SearchBar /> */}
                        <JobTable jobData={filteredJobs}/>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}

export default HomePage;