import React from 'react';
import axios from 'axios';

function GetBestSellingApps(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_best_selling_applications`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetBestSellingApps;