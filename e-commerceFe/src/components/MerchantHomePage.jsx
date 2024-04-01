import React from 'react'
import { Routes,Route } from 'react-router-dom'
import ProductView from './ProductView'
import MerchantNavbar from './MerchantNavbar'
import UpdateMerchant from './UpdateMerchant'
import AddProducts from './AddProducts'
import UpdateProduct from './UpdateProduct'

const MerchantHomePage = () => {
  return (
    <div className='merchanthomepage'>
      <MerchantNavbar/>
      <Routes>
        <Route path="/productview" element={<ProductView/>} ></Route>
        <Route path="/updatemerchant" element={<UpdateMerchant/>}></Route>
        <Route path="/addproducts" element={<AddProducts/>}></Route>
        <Route path="/updateproduct/:id" element={<UpdateProduct/>}></Route>
      </Routes>
    </div>
  )
}

export default MerchantHomePage
