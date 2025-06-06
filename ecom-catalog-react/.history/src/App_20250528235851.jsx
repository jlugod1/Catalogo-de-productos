

import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
 const [products, setProducts] = useState([]);


 useEffect(() =>{fetch ('http://localhost:8080/api/products')
  .then(response => response.json())
   .then(data => setProducts(data));
  
  },[]);

  return (
<div className='container'>
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
