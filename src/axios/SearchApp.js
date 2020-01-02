import React from 'react';
import axios from 'axios';

function SearchApp(props) {

    console.log("Enters");

    const app = {
        text: props.text
      }

      axios.post(`http://localhost:8080/search_app/`, app )
      .then(res => {
        let apps = [];
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default SearchApp;
