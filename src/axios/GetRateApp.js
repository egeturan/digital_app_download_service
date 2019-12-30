import React from 'react';
import axios from 'axios';

function GetRateApp(props) {

  console.log(props.value);

  const app = {
    app_name: props.app_name
  }

  axios.post(`http://localhost:8080/get_rate_app/`, app )
      .then(res => {
        console.log(res);
        console.log("Rate is: " + res.data);
        
      })

  return <div></div>;
}

export default GetRateApp;