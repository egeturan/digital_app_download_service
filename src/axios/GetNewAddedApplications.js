import React from 'react';
import axios from 'axios';

function GetNewAddedApplications(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_new_added_applications`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetNewAddedApplications;