import React from 'react';
import axios from 'axios';

function GetAppMostDownloaded(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_app_most_downloaded`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetAppMostDownloaded;