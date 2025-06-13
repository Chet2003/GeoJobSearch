import React, { useState } from 'react';
import { Table, Button } from 'react-bootstrap';
import SearchBar from '../SearchBar';

const JobTable = ({ tableTitle = 'About Job' }) => {
  const [currentPage, setCurrentPage] = useState(1);
  const [searchedJobs, setSearchedJobs] = useState([]);
  const [jobsPerPage] = useState(5); // Number of jobs per page

  const indexOfLastJob = currentPage * jobsPerPage;
  const indexOfFirstJob = indexOfLastJob - jobsPerPage;
  const currentJobs = searchedJobs.length > 0 ? searchedJobs.slice(indexOfFirstJob, indexOfLastJob):[];

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <>
      <h2 className="">{tableTitle}</h2>
      <SearchBar setSearchedJobs={setSearchedJobs} />
      {currentJobs.length > 0 ? (
        <div>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>Match Rank</th>
                <th>Company</th>
                <th>Position</th>
                <th>Location</th>
              </tr>
            </thead>
            <tbody>
              {currentJobs.map((job, index) => (
                <tr key={index}>
                  <td>{indexOfFirstJob + index + 1}</td>
                  <td>{job.company}</td>
                  <td>{job.jobTitle}</td>
                  <td>{job.location}</td>
                </tr>
              ))}
            </tbody>
          </Table>
          <div>
            <Button
              variant="primary"
              onClick={() => paginate(currentPage - 1)}
              disabled={currentPage === 1}
            >
              Previous
            </Button>
            <Button
              variant="primary"
              onClick={() => paginate(currentPage + 1)}
              disabled={indexOfLastJob >= searchedJobs.length}
            >
              Next
            </Button>
          </div>
        </div>
      ) : (
        <p>No job data found</p>
      )}
    </>
  );
};

export default JobTable;
