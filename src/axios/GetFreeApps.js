import React from 'react';
import axios from 'axios';

function GetFreeApps(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_free_applications`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetFreeApps;