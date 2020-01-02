import React from 'react';
import axios from 'axios';

function DownloadApp(props) {

  console.log(props.value);

  const device = {
    device_id: props.device_id,
    user_id: props.user_id,
    app_name: props.app_id
  }

  axios.post(`http://localhost:8080/download_app/`, device )
      .then(res => {
        console.log(res);
        console.log(device);
        
      })

  return <div></div>;
}

export default DownloadApp;