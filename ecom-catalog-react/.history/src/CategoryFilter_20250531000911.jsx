const CategoryFilter = ({ categories, onSelect }) => {
  return (
    <div className="row">
     <>
     <select id="categorySelect" className="form-control" onChange={(e) => onSelect(e.target.value)}>

              <option value="">All categories</option>
              {categories.map(category => (

<option key={category.id} value={category.id}>{category.name}</option>


              ) )}

     </select>
     
     </>
    </div>
  );
};

export default CategoryFilter;