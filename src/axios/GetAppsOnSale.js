import React from 'react';
import axios from 'axios';

function GetAppsOnSale(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_app_on_sale`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetAppsOnSale;