import React from 'react';
import axios from 'axios';

function GetPriceRangedApplications(props) {

  console.log(props.value);

  const price = {
    lowwer_price: props.lowwer_price,
    upper_price: props.upper_price
  }

  axios.post(`http://localhost:8080/get_price_ranged_applications/`, app )
      .then(res => {
        console.log(res);
        console.log(price);
        
      })

  return <div></div>;
}

export default GetPriceRangedApplications;