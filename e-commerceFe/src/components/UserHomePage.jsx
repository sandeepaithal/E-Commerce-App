import React from 'react'
import { Routes,Route } from 'react-router-dom'
import UpdateUser from './UpdateUser'
import UserNavbar from './UserNavbar'
import Address from './Address'

import EditAddress from './EditAddress'
const UserHomePage = () => {
  return (
    <div className='userhomepage'>
       
      <UserNavbar/>
      <Routes>
        <Route path="/updateuser" element={<UpdateUser/>}></Route>
        <Route path="/address" element={<Address/>}></Route>
        <Route path="/address/editaddress" element={<EditAddress/>}></Route>
      </Routes>
    </div>
    
  )
}

export default UserHomePage
