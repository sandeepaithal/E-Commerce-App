import React from 'react'
import { useState , useEffect} from 'react'
import axios from 'axios'

const EditAddress = () => {
 const[id,setid]=useState("")
  const[addresstype,setaddresstype]=useState("")
  const[buildingname,setbuildingname]=useState("")
  const[city,setcity]=useState("")
  const[country,setcountry]=useState("")
  const[houseno,sethouseno]=useState("")
  const[landmark,setlandmark]=useState("")
  const[pincode,setpincode]=useState("")
  const[state,setstate]=useState("")

  let data={addresstype,buildingname,city,country,houseno,landmark,pincode,state,id}
 
 
  useEffect(()=>{
    let address=JSON.parse(localStorage.getItem("addressData"))
    setid(address.setid)
    setaddresstype(address.addresstype)
    setbuildingname(address.buildingname)
    setcity(address.city)
    setcountry(address.country)
    sethouseno(address.houseno)
    setlandmark(address.landmark)
    setpincode(address.pincode)
    setstate(address.state)
  
  },[])

  let updateData=(e)=>{
    e.preventDefault();
    axios.put(`http://localhost:8080/address`,data)
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
    <div className='editaddress'>
      <form onSubmit={updateData} action="">
             
             <label htmlFor="">Address-Type</label> 
             <input required value={addresstype} onChange={(e)=>{setaddresstype(e.target.value)}} type="text" placeholder= "Addresstype" ></input>
             <label htmlFor="">Building name</label> 
             <input required value={buildingname} onChange={(e)=>{setbuildingname(e.target.value)}} type="text" placeholder= "Building name" ></input>
             <label htmlFor="">City</label> 
             <input required value={city} onChange={(e)=>{setcity(e.target.value)}} type="text" placeholder= "City"  ></input>
            <label htmlFor="">House no</label> 
             <input required value={houseno} onChange={(e)=>{sethouseno(e.target.value)}} type="number" placeholder= "House no" ></input>
             <label htmlFor="">Landmark</label> 
             <input required value={landmark} onChange={(e)=>{setlandmark(e.target.value)}} type="text" placeholder= "Country" ></input>
             <label htmlFor="">Country</label> 
             <input required value={country} onChange={(e)=>{setcountry(e.target.value)}} type="text" placeholder= "Country" ></input>
             <label htmlFor="">PinCode</label> 
             <input required value={pincode} onChange={(e)=>{setpincode(e.target.value)}} type="number" placeholder= "pincode" ></input>
             <label htmlFor="">State</label> 
             <input required value={state} onChange={(e)=>{setstate(e.target.value)}} type="text" placeholder= "state" ></input>
         <button className='btn btn-outline-info'>Submit</button>
             
             
             
            </form> 
    </div>
  )
}

export default EditAddress

