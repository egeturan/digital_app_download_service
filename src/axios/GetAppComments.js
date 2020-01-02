import React from 'react';
import axios from 'axios';

function GetAppComments(props) {

  console.log(props.value);

  const comment = {
    app_id: props.app_id
  }

  axios.post(`http://localhost:8080/get_apps_comments/`, comment )
      .then(res => {
        console.log(res);
        console.log(comment);
        
      })

  return <div></div>;
}

export default GetAppComments;