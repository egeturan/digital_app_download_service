import React from 'react';
import axios from 'axios';

function GetOwnedPayment(props) {

  console.log(props.value);

  const comment = {
    user_id: props.user_id
  }

  axios.post(`http://localhost:8080/get_owned_payments/`, comment )
      .then(res => {
        console.log(res);
        console.log(comment);
        
      })

  return <div></div>;
}

export default GetOwnedPayment;