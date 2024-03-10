import React from 'react'
import { Link } from 'react-router-dom'
import '../styles/LandingPage.css'
const LandingPage = () => {
  return (
    <div>
      <div className='div1'>
        <h1>WELCOME TO E-COMMERCE APP</h1>
      </div>
    <div  className= "landingPage"> 
    
      <Link to="/merchant">
      
        <img  src="https://images.freeimages.com/fic/images/icons/61/dragon_soft/512/user.png"></img>
       
        Merchant
      </Link>
      <Link to="/user">
        <img  src= "https://icon-library.com/images/person-flat-icon/person-flat-icon-8.jpg"></img>
        
        User</Link>

    </div>
    </div>
  )
}

export default LandingPage
