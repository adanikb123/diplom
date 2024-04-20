import { useParams,Link } from 'react-router-dom';

export const Storage = () => {
  const { fileName } = useParams();

  return (
    <Link to={`/storage/${fileName}`}>
    </Link>
  );
  }


