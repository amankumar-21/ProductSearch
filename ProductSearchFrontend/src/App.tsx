import './App.css';
//import { products } from "./proddetails"
import { useState, useEffect } from "react";
import { Table } from "./table";
import axios from "axios";

type productType =
  {
    id: number;
    name: string;
    price: number;
    brand: string;
    rating: number;
  }[]

function App() {
  const [query, setQuery] = useState("");
  const [data, setData] = useState([]);

  useEffect(() => {
    axios('http://localhost:8080/products')
      .then(response => {
        setData(response.data);;
      })

  }, [])

  const searching = (productobj: productType) => {
    return productobj.filter((item) => item.name.toLowerCase().includes(query) || item.id.toString().includes(query))
  }

  return (
    <div className="App">
      <input type="text"
        placeholder="Search Product Id Or Product Name"
        className="search"
        onChange={(e) => setQuery(e.target.value.toLowerCase())}
      />

      <Table filterdata={searching(data)}></Table>

    </div>
  );
}

export default App;
