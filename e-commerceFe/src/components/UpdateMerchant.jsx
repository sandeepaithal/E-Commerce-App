import React,{ useEffect, useState } from 'react'
import '../styles/UpdateMerchant.css';
import axios from 'axios';


const UpdateMerchant = () => {
  let [email,setemail]=useState("")
  let [name,setname]=useState("")
  let[gst_number,setgstnumber]=useState("")
  let[phone,setphone]=useState("")
  let [password,setpassword]=useState("")
  let[id,setid]=useState("")

  let data={name,email,gst_number,phone,password,id}
  let merchant=JSON.parse(localStorage.getItem("Merchant"))

  useEffect(()=>{
    setid(merchant.id)
    setname(merchant.name)
    setemail(merchant.email)
    setgstnumber(merchant.gst_number)
    setphone(merchant.phone)
    setpassword(merchant.password)
  
  },[])

  let updateData=(e)=>{
    e.preventDefault();
    axios.put(`http://localhost:8080/merchants`,data)
    .then((res)=>{
      console.log(res);
      alert("Data Edited Successfully")
    })
    .catch((err)=>{
      console.log(err);
      alert("Data Not Found")
    })

  }

  

  return (
    <div className='merchantsignup'>
        <form onSubmit={updateData} action="">
             
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

export default UpdateMerchant
