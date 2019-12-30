import React from 'react';
import axios from 'axios';

function GetAppBestRate(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_app_best_rate`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetAppBestRate;