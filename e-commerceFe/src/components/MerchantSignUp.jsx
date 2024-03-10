import React, { useState } from 'react'
import '../styles/MerchantSignUp.css'
import axios from 'axios'

const MerchantSignUp = () => {
    let [email,setemail]=useState("")
    let [name,setname]=useState("")
    let[gst_number,setgstnumber]=useState("")
    let[phone,setphone]=useState("")
    let [password,setpassword]=useState("")

    let data={name,email,gst_number,phone,password}

    let addMerchant=(e)=>{
      e.preventDefault();
      axios.post(`http://localhost:8080/merchants`,data)
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
   
    <div className="merchantsignup">
          
        <form onSubmit={addMerchant} action="">
             
           <label htmlFor="">Name</label> 
           <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder= "Name" ></input>
           <label htmlFor="">Gst_number</label> 
           <input required value={gst_number} onChange={(e)=>{setgstnumber(e.target.value)}} type="text" placeholder= "Gst_number" ></input>
           <label htmlFor="">Phone</label> 
           <input required value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" placeholder= "Phone no" pattern="[0-9]{10}" ></input>
           <label htmlFor="">Email</label> 
           <input required value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder= "Email" ></input>
           <label htmlFor="">Password</label> 
           <input required value={password} onChange={(e)=>{setpassword(e.target.value)}} type="text" placeholder= "Password" ></input>
           <button className='btn btn-outline-info'>Submit</button>
            
            
            
            </form> 
    
    
    
    
    
    
    
        </div>
  )
}

export default MerchantSignUp
