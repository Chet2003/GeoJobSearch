import React, { useState } from 'react';
import Dropdown from 'react-bootstrap/Dropdown';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import SplitButton from 'react-bootstrap/SplitButton';



const SearchBar = ({setSearchedJobs}) => {
    const [searchValue, setSearchValue] = useState('');

    // Handle change event of the search input
    const handleInputChange = (event) => {
        setSearchValue(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch(`/api/jobs/search/${searchValue}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
                // body: JSON.stringify({ query: searchValue })
            });
        
            if (response.ok) {
                // Handle success
                const data = await response.json(); // Parse JSON response
                console.log('Search submitted successfully.');
                console.log(data); // Log the parsed data
                setSearchedJobs(data);
            } else {
                console.error('Failed to submit search.');
            }
        } catch (error) {
            console.error('Error occurred while submitting search:', error);
        }
    };

    return (
        <>
            {/* <form onSubmit={handleSubmit}> */}
                <InputGroup className="mb-3">
                    <Form.Control 
                        type="text"
                        value={searchValue}
                        onChange={handleInputChange}
                        placeholder="Search..."
                        aria-label="Text input with dropdown button" 
                        sz={"sm"} 
                    />
                    <SplitButton
                        variant="outline-secondary"
                        title="Search"
                        id="segmented-button-dropdown-2"
                        alignRight
                        onClick={handleSubmit}
                        type='submit'
                    >
                        <Dropdown.Item disabled href="#">Description</Dropdown.Item>
                        <Dropdown.Item disabled href="#">Salary</Dropdown.Item>
                        <Dropdown.Item disabled href="#">Title</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item href="#">All</Dropdown.Item>
                    </SplitButton>
                </InputGroup>
                {/* <button type="submit" style={{ display: 'none' }}>Submit</button> */}
            {/* </form> */}
        </>
    );
}

export default SearchBar;