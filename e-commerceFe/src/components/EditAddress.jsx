import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import '../styles/EsitAddress.css'

const EditAddress = () => {
  const [id, setid] = useState('');
  const [addresstype, setaddresstype] = useState('');
  const [buildingname, setbuildingname] = useState('');
  const [city, setcity] = useState('');
  const [country, setcountry] = useState('');
  const [houseno, sethouseno] = useState('');
  const [landmark, setlandmark] = useState('');
  const [pincode, setpincode] = useState('');
  const [state, setstate] = useState('');

  const param = useParams();

  useEffect(() => {
    axios.get(`http://localhost:8080/address/find-by-id/${param.id}`)
      .then((res) => {
        const { data } = res;
        setaddresstype(data.body.addresstype);
        setbuildingname(data.body.buildingname);
        setcity(data.body.city);
        setcountry(data.body.country);
        sethouseno(data.body.houseno);
        setlandmark(data.body.landmark);
        setid(data.body.id);
      })
      .catch((err) => {
        console.log(err); 
      });
  }, [param.id]);

  const updateData = (e) => {
    e.preventDefault();
    const data = { addresstype, buildingname, city, country, houseno, landmark, pincode, state, id };
    axios.put('http://localhost:8080/address', data)
      .then((res) => {
        console.log(res);
        alert('Data Edited Successfully');
      })
      .catch((err) => {
        console.log(err);
        alert('Data Not Found');
      });
  };

  return (
    <div className='editaddress'>
      <form onSubmit={updateData} action="">
        <label htmlFor="">Address-Type</label>
        <input required value={addresstype} onChange={(e) => { setaddresstype(e.target.value) }} type="text" placeholder="Addresstype" />
        <label htmlFor="">Building name</label>
        <input required value={buildingname} onChange={(e) => { setbuildingname(e.target.value) }} type="text" placeholder="Building name" />
        <label htmlFor="">City</label>
        <input required value={city} onChange={(e) => { setcity(e.target.value) }} type="text" placeholder="City" />
        <label htmlFor="">House no</label>
        <input required value={houseno} onChange={(e) => { sethouseno(e.target.value) }} type="number" placeholder="House no" />
        <label htmlFor="">Landmark</label>
        <input required value={landmark} onChange={(e) => { setlandmark(e.target.value) }} type="text" placeholder="Country" />
        <label htmlFor="">Country</label>
        <input required value={country} onChange={(e) => { setcountry(e.target.value) }} type="text" placeholder="Country" />
        <label htmlFor="">PinCode</label>
        <input required value={pincode} onChange={(e) => { setpincode(e.target.value) }} type="number" placeholder="pincode" />
        <label htmlFor="">State</label>
        <input required value={state} onChange={(e) => { setstate(e.target.value) }} type="text" placeholder="state" />
        <button className='btn btn-outline-info' type="submit">Submit</button>
      </form>
    </div>
  );
};

export default EditAddress;
