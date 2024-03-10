import React, { useState } from 'react'
import axios from 'axios'
import '../styles/UserSignUp.css'

const UserSignUp = () => {
    let [email,setemail]=useState("")
    let [name,setname]=useState("")
    let[age,setage]=useState("")
    let[gender,setgender]=useState("")
    let[phone,setphone]=useState("")
    let [password,setpassword]=useState("")

    let data={name,email,age,gender,phone,password}

    let addUser=(e)=>{
      e.preventDefault();
      axios.post(`http://localhost:8080/User`,data)
      .then((res)=>{
        console.log(res);
        alert("Data Added Successfully")
      })
      .catch((err)=>{
        console.log(err);
        alert("Data Not Found")
      })
    }
  
    return (
   
    <div className="usersignup">
          
        <form onSubmit={addUser} action="">
             
           <label htmlFor="">Name</label> 
           <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder= "Name" ></input>
           <label htmlFor="">Age</label> 
           <input required value={age} onChange={(e)=>{setage(e.target.value)}} type="text" placeholder= "age" ></input>
           <label htmlFor="">Phone</label> 
           <input required value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" placeholder= "Phone no" pattern=" [6789][0-9]{10}" ></input>
           <label htmlFor="">Email</label> 
           <input required value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder= "Email" ></input>
           <label htmlFor="">Password</label> 
           <input required value={password} onChange={(e)=>{setpassword(e.target.value)}} type="text" placeholder= "Password" ></input>
           <label htmlFor="">Gender</label> 
           <input required value={gender} onChange={(e)=>{setgender(e.target.value)}} type="text" placeholder= "gender" n ></input>
           <button className='btn btn-outline-info'>Submit</button>  
            </form> 
        </div>
  )
}

export default UserSignUp
