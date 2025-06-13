import React, { useState } from 'react';

const AddMarkerForm = ({ onSubmit }) => {
  const [address, setAddress] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(address);
    setAddress(''); // Clear input after submission
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="address">Enter address:</label>
      <input
        type="text"
        id="address"
        value={address}
        onChange={(e) => setAddress(e.target.value)}
      />
      <button type="submit">Add Marker</button>
    </form>
  );
};

export default AddMarkerForm;
