

import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
 const [products, setProducts] = useState([]);
const [categories, setCategories] = useState([]);

const [selectedCategories, setSelectedCategories] = useState([null]);

const [searchTerm, setSearchTerm] = useState([""]);
const [sortOrder, setSortOrder] = useState("asc");

 useEffect(() =>
  {fetch ('http://localhost:8080/api/products')
  .then(response => response.json())
   .then(data => 
     // 👈 Verifica la forma del JSON
      setProducts(data)
    );

     fetch ('http://localhost:8080/api/categories')
  .then(response => response.json())
   .then(data => {
      console.log("Datos recibidos:", data); // 👈 Verifica la forma del JSON
      setCategories(data);
    });





  
  },[]);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  }

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

   const handlecategorySelect = (categoryId) => {
    setSelectedCategories(categoryId ? Number(categoryId) : null);
  }

  return (
<div className='container'>
<h1 className='my-4'>Product catalog</h1>

<div className='row align-items'>
  <div className='col-md-3 col-sm-12 mb-2'>

<CategoryFilter categories={categories} onSelect={handlecategorySelect}/>
  </div>
<div className='col-md-5 col-sm-12 mb-2'>

<input type="text" 
       className='form-control'
       placeholder='Search for products'    />
       onChange={handleSearchChange}
</div>
<div className='col-md-4 col-sm-12 mb-2'>

  <select className='form-control' onChange={handleSortChange}>

    <option value="asc"> sort by Price: low to high</option>
    <option value="desc"> Price by sort: high to high</option>
  </select>

</div>

</div>

<div>
{products.length ?  (

  //Display the products

 <ProductList products={products}/>
): (

      <p>  No Products found </p>

)}


</div>

</div>
  
  )
}

export default App
