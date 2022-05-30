
type productprops={
    filterdata :{
        id: number
        name : string
        brand : string
        rating : number
        price : number
    }[]
}

export  const Table = (props : productprops) => {
    return (
      <table>
        <tbody>
          <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Brand </th>
            <th>Rating </th>
            <th>Price </th>
          </tr>
          {props.filterdata.map(product=>(
            <tr key={product.id}>
                <td> {product.id}</td>
                <td> {product.name}</td>
                <td>{product.brand} </td>
                <td> {product.rating}</td>
                <td>$ {product.price} </td>               
            </tr>
              ))}
          
         
        </tbody>
      </table>
    );
  };
  
