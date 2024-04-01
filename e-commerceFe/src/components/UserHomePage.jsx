import React from 'react'
import { Routes,Route } from 'react-router-dom'
import UpdateUser from './UpdateUser'
import UserNavbar from './UserNavbar'
import Address from './Address'

import EditAddress from './EditAddress'
import AddAddress from './AddAddress'
import AllProducts from './AllProducts'
import ReadContent from './ReadContent'
import Cart from './Cart'
const UserHomePage = () => {
  return (
    <div className='userhomepage'>
       
      <UserNavbar/>
      <Routes>
        <Route path="/updateuser" element={<UpdateUser/>}></Route>
        <Route path="/address" element={<Address/>}></Route>
        <Route path="/address/editaddress" element={<EditAddress/>}></Route>
        <Route path="/address/addaddress" element={<AddAddress/>}></Route>
        <Route path="/" element={<AllProducts/>}></Route>
        <Route path='/readData/:id' element={<ReadContent/>}/>
        
        
      </Routes>
    </div>
    
  )
}

export default UserHomePage
