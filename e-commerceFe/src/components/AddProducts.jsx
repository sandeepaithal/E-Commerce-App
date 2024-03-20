import React, { useState } from 'react'
import axios from 'axios'
import '../styles/AddProducts.css'

const AddProducts = () => {
 let[name,setname]=useState("")
 let[brand,setbrand]=useState("")
 let[category,setcategory]=useState("")
 let[description,setdescription]=useState("")
 let[cost,setcost]=useState("")
 let[image_url,setimage_url]=useState("")
 let [id,setid]=useState("")

 let data={name,brand,category,description,cost,image_url,id}
let admin=JSON.parse(localStorage.getItem("Merchant"))
 let addData=(e)=>{
    e.preventDefault();
    axios.post(`http://localhost:8080/products/${admin.id}`,data)
    .then((res)=>{
      console.log(res);
      alert("Data Added Successfully")
    })
    .catch((err)=>{
      console.log(err);
      alert("Something went wrong")
    })
  }
 
 
    return (
    <div className='addproducts'>
         <form onSubmit={addData} action="">
             
             <label htmlFor="">Name</label> 
             <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder= "Name" ></input>
             <label htmlFor="">Brand</label> 
             <input required value={brand} onChange={(e)=>{setbrand(e.target.value)}} type="text" placeholder= "Brand" ></input>
             <label htmlFor="">Category</label> 
             <input required value={category} onChange={(e)=>{setcategory(e.target.value)}} type="text" placeholder= "Category" ></input>
             <label htmlFor="">Description</label> 
             <input required value={description} onChange={(e)=>{setdescription(e.target.value)}} type="text" placeholder= "Description" ></input>
             <label htmlFor="">Cost</label> 
             <input required value={cost} onChange={(e)=>{setcost(e.target.value)}} type="text" placeholder= "Cost" ></input>
             <label htmlFor="">Image</label> 
             <input required value={image_url} onChange={(e)=>{setimage_url(e.target.value)}} type="text" placeholder= "Image Address" ></input>
             <button className='btn btn-success'>Submit</button>
              
              
              
              </form> 
       
    </div>
  )
}

export default AddProducts


