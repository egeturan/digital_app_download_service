import React, { useRef, useState } from 'react';

import Button from 'react-bootstrap/Button';

import ButtonToolbar from 'react-bootstrap/ButtonToolbar';

import Modal from 'react-bootstrap/Modal';

function Example() {
  const [lgShow, setLgShow] = useState(false);

  return (
    <ButtonToolbar>
      <Button onClick={() => setLgShow(true)}>Large modal</Button>
      <Button variant="success" style={{marginLeft:"5px"}}>Mesaj Gönder</Button>

      <Modal
        size="lg"
        show={lgShow}
        onHide={() => setLgShow(false)}
        aria-labelledby="example-modal-sizes-title-lg"
      >
        <Modal.Header closeButton>
          <Modal.Title id="example-modal-sizes-title-lg">
            Large Modal
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>...</Modal.Body>
      </Modal>
    </ButtonToolbar>
  );
}

export default Example;