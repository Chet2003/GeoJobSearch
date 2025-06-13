import React, { useState } from 'react';
import Map from './components/Map';
import AddMarkerForm from './components/AddMarkerForm';

const MapPage = () => {
  const [markers, setMarkers] = useState([]);

  const geocodeAddress = async (address) => {
    const response = await fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${address}`);
    const data = await response.json();
    if (data.length > 0) {
      const { lat, lon } = data[0];
      return { lat: parseFloat(lat), lng: parseFloat(lon)};
    }
    throw new Error('Address not found');
  };

  const addMarker = async (address) => {
    try {
      const {lat, lng} = await geocodeAddress(address);
      const popupContent = `<b>${address}</b>`;
      const marker = { lat, lng, popupContent };
      console.log(marker)
      setMarkers((prevMarkers) => [...prevMarkers, marker]);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="MapPage">
      <AddMarkerForm onSubmit={addMarker} />
      <Map markers={markers} className={"pt-4"}/>
    </div>
  );
};

export default MapPage;
