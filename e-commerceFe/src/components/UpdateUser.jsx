import React, { useEffect, useState } from 'react';
import axios from 'axios';

const UpdateUser = () => {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [gender, setGender] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");
  const [id, setId] = useState("");

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("User"));
    if (user) {
      setId(user.id);
      setName(user.name);
      setEmail(user.email);
      setGender(user.gender);
      setPhone(user.phone);
      setPassword(user.password);
      setAge(user.age);
    }
  }, []);

  const updateData = (e) => {
    e.preventDefault();
    const data = { name, email, age, gender, phone, password, id };
    axios.put(`http://localhost:8080/User`, data)
      .then((res) => {
        console.log(res);
        alert("Data Edited Successfully");
      })
      .catch((err) => {
        console.log(err);
        alert("Data Not Found");
      });
  };

  return (
    <div className='usersignup'>
      <form onSubmit={updateData} action="">
        <label htmlFor="">Name</label>
        <input required value={name} onChange={(e) => setName(e.target.value)} type="text" placeholder="Name" />
        <label htmlFor="">Age</label>
        <input required value={age} onChange={(e) => setAge(e.target.value)} type="text" placeholder="age" />
        <label htmlFor="">Phone</label>
        <input required value={phone} onChange={(e) => setPhone(e.target.value)} type="tel" placeholder="Phone no" />
        <label htmlFor="">Email</label>
        <input required value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="Email" />
        <label htmlFor="">Password</label>
        <input required value={password} onChange={(e) => setPassword(e.target.value)} type="text" placeholder="Password" />
        <label htmlFor="">Gender</label>
        <input required value={gender} onChange={(e) => setGender(e.target.value)} type="text" placeholder="gender" />
        <button className='btn btn-outline-info'>Submit</button>
      </form>
    </div>
  );
};

export default UpdateUser;
