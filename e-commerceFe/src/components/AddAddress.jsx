import React, { useState } from 'react';
import axios from 'axios';

const AddAddress = () => {






    const [id, setId] = useState("");
    const [addresstype, setAddresstype] = useState("");
    const [buildingname, setBuildingname] = useState("");
    const [city, setCity] = useState("");
    const [country, setCountry] = useState("");
    const [houseno, setHouseno] = useState("");
    const [landmark, setLandmark] = useState("");
    const [pincode, setPincode] = useState("");
    const [state, setState] = useState("");

    const addAddress = (e) => {
        e.preventDefault();
        let data = { id, addresstype, buildingname, city, country, houseno, landmark, pincode, state };
        let admin=JSON.parse(localStorage.getItem("User"))
        axios.post(`http://localhost:8080/address/${admin.id}`, data)
            .then((res) => {
                console.log(res);
                alert("Data Added Successfully");
            })
            .catch((err) => {
                console.log(err);
                alert("Data Not Found");
            });
    };

    return (
        <div className='addaddress'>
            <form onSubmit={addAddress}>
                <label htmlFor="addresstype">Address-Type</label>
                <input id="addresstype" required value={addresstype} onChange={(e) => { setAddresstype(e.target.value) }} type="text" placeholder="Addresstype"></input>
                <label htmlFor="buildingname">Building name</label>
                <input id="buildingname" required value={buildingname} onChange={(e) => { setBuildingname(e.target.value) }} type="text" placeholder="Building name"></input>
                <label htmlFor="city">City</label>
                <input id="city" required value={city} onChange={(e) => { setCity(e.target.value) }} type="text" placeholder="City"></input>
                <label htmlFor="houseno">House no</label>
                <input id="houseno" required value={houseno} onChange={(e) => { setHouseno(e.target.value) }} type="number" placeholder="House no"></input>
                <label htmlFor="landmark">Landmark</label>
                <input id="landmark" required value={landmark} onChange={(e) => { setLandmark(e.target.value) }} type="text" placeholder="Landmark"></input>
                <label htmlFor="country">Country</label>
                <input id="country" required value={country} onChange={(e) => { setCountry(e.target.value) }} type="text" placeholder="Country"></input>
                <label htmlFor="pincode">PinCode</label>
                <input id="pincode" required value={pincode} onChange={(e) => { setPincode(e.target.value) }} type="number" placeholder="Pincode"></input>
                <label htmlFor="state">State</label>
                <input id="state" required value={state} onChange={(e) => { setState(e.target.value) }} type="text" placeholder="State"></input>
                <button type="submit" className='btn btn-outline-info'>Submit</button>
            </form>
        </div>
    );
};

export default AddAddress;
