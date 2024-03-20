
import React from 'react'
import { Link } from 'react-router-dom'
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Dropdown from 'react-bootstrap/Dropdown';
import '../styles/navbar.css';

const MerchantNavbar = () => {
    return (
        <nav>
            <div className='navbar'>
            <div className="logo">
                <h1>SHOPPERS CART <ShoppingCartIcon/></h1>
            </div>
            <div className="option">
                <Link to="/merchanthomepage/productview">View Products</Link>
                <Link to="/merchanthomepage/addproducts">Add Products</Link>
            </div>
            <div className="account">
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                       <AccountCircleIcon/> Account
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="/merchanthomepage/updatemerchant">Edit Profile</Dropdown.Item>
                        <Dropdown.Item href="/">logout</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            </div>
        </nav>
    )
}

export default MerchantNavbar
