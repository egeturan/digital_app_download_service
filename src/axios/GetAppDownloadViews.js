import React from 'react';
import axios from 'axios';

function GetAppDownloadViews(props) {

  console.log(props.value);

  axios.get(`http://localhost:8080/get_app_download_views`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetAppDownloadViews;