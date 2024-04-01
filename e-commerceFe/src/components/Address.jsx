import React from 'react'
import { useState , useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

const Address = () => {
    let [content,setContent]=useState([])
    let admin=JSON.parse(localStorage.getItem("User"))

    useEffect(()=>{
        axios
        .get(`http://localhost:8080/address/${admin.id}`)
        .then((response)=>{
          console.log(response);
          setContent(response.data.body)
          localStorage.setItem("addressData", JSON.stringify(response.data.body));
      })
        .catch(()=>{console.log("Something went wrong");})
            
       },[])
    
  return (
    <div className='address'>
      {content.map((x)=>{
      return(<div className='adddiv'>
        
      
      <p> Address type : {x.addresstype}</p>
      <p> Building name : {x.buildingname}</p>
      <p> City : {x.city}</p>
      <p> Country : {x.country}</p>
      <p> House no : {x.houseno}</p>
      <p> Landmark : {x.landmark}</p>
      <p> Pincode : {x.pincode}</p>
      <p> State : {x.state}</p>
      <button  className="btn btn-outline-info"><Link to="editaddress">Edit</Link></button>
      <button className="btn btn-outline-danger">Delete</button>
      <button  className="btn btn-outline-info"><Link to="addaddress">Add</Link></button>
      </div>
       )
    })}
    </div>
  )
}

export default Address

