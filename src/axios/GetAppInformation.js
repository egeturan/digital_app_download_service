import React from 'react';
import axios from 'axios';
import GLOBAL from '../global';

function GetAppInformation(props) {

  console.log(props.value);

  const app = {
    app_name: props.app_name
  }

  axios.post(`http://localhost:8080/app_information/`, app )
      .then(res => {
        console.log(res);
        console.log(app);
        
      })

  return <div></div>;
}

export default GetAppInformation;