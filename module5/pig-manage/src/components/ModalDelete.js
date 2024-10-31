import { Modal, Button } from 'react-bootstrap';
import { useDispatch } from "react-redux";
import { deletePig } from '../redux/action';
import { toast } from 'react-toastify';

function ModalDelete({ show, onHide, pig }) {
    const dispatch = useDispatch();

    const handleDelete = (data) => {
        dispatch(deletePig(data))
        toast.success('🦄 Delete Success!', {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
        });
        onHide();
    };

    return (
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton>
                <Modal.Title>Bạn có muốn xoá heo có mã số {pig.id}</Modal.Title>
            </Modal.Header>
            <Modal.Footer>
                <Button variant="secondary" onClick={onHide}>
                    Close
                </Button>
                <Button variant="danger" onClick={() => handleDelete(pig)}>
                    Delete
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default ModalDelete;