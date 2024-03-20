import Dropdown from 'react-bootstrap/Dropdown';
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import "../styles/ProductView.css"

const Productview = () => {

  let [content, setContent] = useState([])
  let admin = JSON.parse(localStorage.getItem("Merchant"))


  useEffect(() => {
    axios
      .get(`http://localhost:8080/products/${admin.id}`)
      .then((response) => {
        console.log(response);
        setContent(response.data.body)
      })
      .catch(() => { console.log("Something went wrong"); })

  }, [])
let searchByBrand=(brand)=>{
  axios.get(`http://localhost:8080/products/find-by-brand/${brand}`)
  .then((res)=>{
    console.log(res.data.body);
    setContent(res.data.body)
  })
  .catch((err)=>{
    console.log(err);
  })
}
let searchByCategory=(category)=>{
  axios.get(`http://localhost:8080/products/find-by-category/${category}`)
  .then((res)=>{
    console.log(res.data.body)
    setContent(res.data.body)
  })
}
  return (
    <div className='disp'>
      {content.map((x) => {
        return (
          <div>
            <div className="search">
              <div className="brand">
          <Dropdown>
          <Dropdown.Toggle variant="success" id="dropdown-basic">
           search
          </Dropdown.Toggle>
    
          <Dropdown.Menu>
            <Dropdown.Item onClick={()=>{searchByBrand(x.brand)}}>By Brand</Dropdown.Item>
            <Dropdown.Item onClick={()=>{searchByCategory(x.category)}}>By Category</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        </div>
          <div className='productview'>
            <div className="image">
              <span id='category'>{x.category}</span>
              <img src={x.image_url} alt="" />
            </div>
            <div className="desc">
              <h4 id='name'>{x.name} || {x.brand}</h4>
              <span id='cost'><sup><b>₹</b></sup>{x.cost}</span>
              <br />
            </div>
            <span id='desc'>{x.description}</span>

            {/* <button  className="btn btn-outline-info">Edit</button>
         <button className="btn btn-outline-danger">Delete</button> */}
          </div>
          </div>
          </div>
        )
      })}
    </div>
  )
}

export default Productview
