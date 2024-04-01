import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import  '../styles/UsersLogin.css'
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Userslogin = () => {
  let [email,setemail] = useState("")
  let [password,setpassword] = useState("")

  let navigate=useNavigate()

  
  function verifyUser(e) {
    e.preventDefault();
   
   
    axios.post(`http://localhost:8080/User/verifyemail?email=${email}&password=${password}`)
    .then((res)=>{
      console.log(res);
      localStorage.setItem("User",JSON.stringify(res.data.body))
      navigate('/userhomepage')
      alert("Login successfull")
    })
    .catch((err)=>{
      console.log(err);
      alert("Invalid Credentials")
    })
  }

  return (
    <div className='userslogin'>
         <Form>
        <h1>User Login/Sign Up Form</h1>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control value={email} onChange={(e)=>setemail(e.target.value)} type="email" placeholder="Enter email" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control value={password} onChange={(e)=>setpassword(e.target.value)} type="password" placeholder="Password" />
      </Form.Group>
      <Form.Group>
        <button onClick={verifyUser} className='btn btn-success mx-5'>Sign In</button>
        <button className='btn btn-danger mx-5'><Link to ="/usersignup" >Sign Up</Link></button>
      </Form.Group>
    </Form> 
      
    </div>
  )
}

export default Userslogin