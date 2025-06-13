import React, { useEffect, useRef } from 'react';
import L from 'leaflet';


const Map = ({ markers }) => {
  const mapRef = useRef(null); // Ref for the map container
  const mapInstance = useRef(null); // Ref for the map instance
  const markersRef = useRef([]); // Ref to keep track of the marker instances
  
 // Function to handle marker click event
 const handleMarkerClick = (markerData) => {
  if (markerData && markerData.latlng) {
    console.log(markerData.latlng)
    const [ lat, lng ] = markerData.latlng;
    console.log(lat, lng)
    if (typeof lat === 'number' && typeof lng === 'number') {
      // Proceed with creating the popup using lat and lng
      const popupContent = markerData.popupContent;
      console.log(popupContent)
      // Create a popup with the desired content
      const popup = L.popup()
        .setLatLng([lat, lng])
        .setContent(popupContent)
        .openOn(mapInstance.current); // Using openOn will close any previously open popups
    } else {
      console.error("Invalid latitude or longitude:", lat, lng);
    }
  } else {
    console.error("Invalid marker data:", markerData);
  }

  // Log markerData for debugging
  console.log("markerData:", markerData);
};




  useEffect(() => {
    // Initialize the map instance only once
    if (mapInstance.current === null) {
      mapInstance.current = L.map(mapRef.current).setView([43.6532, -79.3832], 13);
      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
      }).addTo(mapInstance.current);
    }
  }, []);

  useEffect(() => {
    // Function to clear all markers
    const clearMarkers = () => {
      markersRef.current.forEach(marker => marker.remove());
      markersRef.current = [];
    };

    // Add markers and adjust the map view
    const addMarkersAndFitBounds = () => {

      const bounds = L.latLngBounds([]);

      markers.forEach(({ lat, lng, popupContent }) => {
        if (typeof lat === 'number' && typeof lng === 'number' && !isNaN(lat) && !isNaN(lng)) {
          console.log(popupContent)
          const marker = L.marker([lat, lng])
            .on('click', () => handleMarkerClick({latlng: [lat, lng], popupContent}))
            .addTo(mapInstance.current);
          markersRef.current.push(marker); // Keep track of the marker
          bounds.extend(marker.getLatLng());
        } else {
          console.error("Invalid latitude or longitude:", lat, lng);
        }
      });
      

      if (bounds.isValid()) {
        mapInstance.current.fitBounds(bounds, { padding: [50, 50] }); // Fit map to marker bounds
      }

    };

    // Clear existing markers and add new ones
    clearMarkers();
    addMarkersAndFitBounds();

    // Cleanup function to remove markers when the component unmounts
    return () => {
      clearMarkers();
    };
  }, [markers]); // Effect runs when the markers prop changes

  return <div ref={mapRef} style={{ height: '400px', width: '100%' }} />;
};

export default Map;
