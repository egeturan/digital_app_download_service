import React from 'react';
import axios from 'axios';
import GLOBAL from '../global';

function RateApp(props) {
  console.log("Ege turan");
  console.log(props.value);

  const user = {
    user_id: props.user_id,
    app_name: props.app_name,
    rate: props.rate
  }

  axios.post(`http://localhost:8080/rate_app/`, user )
      .then(res => {
        console.log(res);
        console.log("Rate completed");
        
      })

  return <div></div>;
}
//value={greeting}
export default RateApp;