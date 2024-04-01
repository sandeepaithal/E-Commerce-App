import React from 'react'
import { Link } from 'react-router-dom'
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Dropdown from 'react-bootstrap/Dropdown';
import '../styles/navbar.css';

const UserNavbar = () => {
  return (
    <div>
              <nav>
            <div className='navbar'>
            <div className="logo">
                <h1>SHOPPERS CART <ShoppingCartIcon/></h1>
            </div>
            <div className="products">
            </div>
            
            
            <div className="account">
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                       <AccountCircleIcon/> Account
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="/userhomepage/addaddress">Add Address</Dropdown.Item>
                        <Dropdown.Item href="/userhomepage/updateuser">Edit Profile</Dropdown.Item>
                        <Dropdown.Item href="/userhomepage/address">Address</Dropdown.Item>
                        <Dropdown.Item href="/">logout</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            </div>
        </nav>
    </div>
  )
}

export default UserNavbar
